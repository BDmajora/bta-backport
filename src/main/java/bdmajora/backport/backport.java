package bdmajora.backport;

import bdmajora.backport.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;
import turniplabs.halplibe.helper.AchievementHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.helper.SoundHelper;

import java.util.Properties;

public class backport implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {

	static {
		//this is here to possibly fix some class loading issues, do not delete
		try {
			Class.forName("net.minecraft.core.block.Block");
			Class.forName("net.minecraft.core.item.Item");
		} catch (ClassNotFoundException ignored) {}
	}

	public static final String MOD_ID = "BackPort";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private void handleConfig() {
		Properties prop = new Properties();
		prop.setProperty("starting_item_id","30000");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		UtilIdRegistrar.initIds(config.getInt("starting_item_id"));
		config.updateConfig();
	}


	@Override
	public void onInitialize() {
		LOGGER.info("BackPort loading! watch out for bugs");
		handleConfig();

		// Register items
		ModItems.register();

		// Add streaming for the music disc
		// Assuming you have a method similar to SoundHelper.addStreaming in your code
		SoundHelper.addStreaming(backport.MOD_ID, "disc_pig_step.ogg");

		LOGGER.info("BackPort loaded successfully!");
	}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}
}