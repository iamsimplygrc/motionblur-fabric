package cn.noryea.motionblur.config;

import cn.noryea.motionblur.MotionBlurMod;
import com.mojang.datafixers.util.Pair;

public class MotionBlurConfig {

    public static SimpleConfig CONFIG;

    public static int MOTIONBLUR_AMOUNT;

    public static void registerConfigs(int amount) {
        MotionBlurConfigProvider provider = new MotionBlurConfigProvider();
        provider.addKeyValuePair(new Pair<>("motionblur.amount", amount));

        CONFIG = SimpleConfig.of(MotionBlurMod.ID).provider(provider).request();
        syncConfigs();
    }

    private static void syncConfigs() {
        MOTIONBLUR_AMOUNT = CONFIG.getOrDefault("motionblur.amount", 50);
    }

    public static void setMotionBlurAmount(int value){
        CONFIG.set("motionblur.amount", value);
        syncConfigs();
    }

}
