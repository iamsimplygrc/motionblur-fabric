package cn.noryea.motionblur.config;

import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class MotionBlurConfigProvider implements SimpleConfig.DefaultConfig {
    private String configContents = "";

    public void addKeyValuePair(Pair<String, ?> keyValuePair) {
        configContents += keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + "\n";
    }

    @Override public String get(String namespace) {
        return "#" + namespace + " config\n" + configContents;
    }
}
