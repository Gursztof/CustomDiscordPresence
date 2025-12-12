import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

void main() throws IOException {

    // Making config folder
    File folder = new File("config");

    if (!folder.exists()) {
        boolean created = folder.mkdir();
        if (created) System.out.println("Config folder successfully created");
    }

    // Making config file

    Properties config = new Properties();
    String configPath = "config/config.properties";
    try {
        File configFile = new File(configPath);

        if (!configFile.exists()) {
            configFile.getParentFile().mkdir();

            config.setProperty("applicationId", "1111111111111");
            config.setProperty("details", "CustomDetails");
            config.setProperty("state", "CustomState");
            config.setProperty("nameOfImageKey", "cat1");

            config.store(new FileOutputStream(configFile), "DiscordRichPresence Config");
            System.out.println("Config file successfully created and saved!");
        }
        config.load(new FileInputStream(configFile));
    } catch (Exception e) {
        System.out.println(e);
    }

    // Reading config file

    String applicationID = config.getProperty("applicationId");
    if (applicationID.equals("1111111111111")) {
        System.out.println("\nPlease navigate to config file and change your applicationId.");
        System.out.println("You can applicationId under this link: https://discord.com/developers/applications\n");
    }
    String details = config.getProperty("details");
    String state = config.getProperty("state");
    String nameOfImageKey = config.getProperty("nameOfImageKey");

    DiscordRPC lib = DiscordRPC.INSTANCE;

    DiscordEventHandlers handlers = new DiscordEventHandlers();
    handlers.ready = (user) -> System.out.println("Working!");
    lib.Discord_Initialize(applicationID, handlers, true, "");

    DiscordRichPresence presence = new DiscordRichPresence();
    presence.startTimestamp = System.currentTimeMillis() / 1000;
    presence.details = details;
    presence.state = state;
    presence.largeImageKey = nameOfImageKey;

    lib.Discord_UpdatePresence(presence);

    new Thread(() -> {
        while(true) {
            lib.Discord_RunCallbacks();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }).start();
}