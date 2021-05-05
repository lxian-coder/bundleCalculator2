package bundleFormatConfig;


import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Darcy Xian  4/5/21  3:47 pm      bundleCalculator
 */

@RequiredArgsConstructor
public class BundlesFormatBootstrap {

    public Map<String, Map<String, String>> createFormatsMap() {
        List<BundlesFormat> formats = loadData();
        Map<String, Map<String, String>> formatsMap = new HashMap<String, Map<String, String>>();
        formats.forEach(dataModel -> {
            formatsMap.put(dataModel.getFormatCode().toLowerCase(), dataModel.getBundles());
        });
        return formatsMap;
    }

    private List<BundlesFormat> loadData() {
        List<BundlesFormat> dataModels = new ArrayList<>();
        BundlesFormat image = new BundlesFormat();
        image.setFormatName("Image");
        image.setFormatCode("Img");
        image.getBundles().put("5", "450");
        image.getBundles().put("10", "800");
        dataModels.add(image);

        BundlesFormat audio = new BundlesFormat();
        audio.setFormatName("Audio");
        audio.setFormatCode("Flac");
        audio.getBundles().put("3", "427.50");
        audio.getBundles().put("6", "810");
        audio.getBundles().put("9", "1147.50");
        dataModels.add(audio);

        BundlesFormat video = new BundlesFormat();
        video.setFormatName("Video");
        video.setFormatCode("Vid");
        video.getBundles().put("3", "570");
        video.getBundles().put("5", "900");
        video.getBundles().put("9", "1530");
        dataModels.add(video);

        BundlesFormat test = new BundlesFormat();
        test.setFormatName("Test");
        test.setFormatCode("test");
        test.getBundles().put("3", "100.50");
        test.getBundles().put("5", "210");
        test.getBundles().put("10", "557.50");
        dataModels.add(test);

        return dataModels;
    }
}
