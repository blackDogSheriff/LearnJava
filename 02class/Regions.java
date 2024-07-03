import JsonUtil;

public enum Regions {
    BEIJING("BEIJING"),
    SHANGHAI("SHANGHAI"),
    HANGZHOU("HANGZHOU"),
    GUANGZHOU("GUANGZHOU"),
    HONGKONG("HONGKONG"),
    QINGDAO("QINGDAO"),
    TAIWAN("TAIWAN"),
    JR_BEIJING("JR_BEIJING"),
    JR_SHANGHAI("JR_SHANGHAI"),
    GOV_BEIJING("GOV_BEIJING"),
    RUSSIA("RUSSIA"),
    SINGAPORE("SINGAPORE"),
    QINGYANGPRE("QINGYANGPRE"),
    NINGXIA("NINGXIA"),
    SINGAPORE2("SINGAPORE2"),
    TIANJIN_XM01("TIANJIN_XM01"),
    CN_SHANGHAI_2("CN-SHANGHAI-2"),
    CN_BEIJING_6("CN-BEIJING-6"),
    CN_GUANGZHOU_1("CN-GUANGZHOU-1");

    private String yinheRegionValue;

    @Override
    public String toString() {
        return this.yinheRegionValue;
    }

    private Regions(String yinheRegionValue) {
        this.yinheRegionValue = yinheRegionValue;
    }

    public static String getYinheRegionValue(String name) {
        Regions[] arr$ = values();
        int len$ = arr$.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            Regions region = arr$[i$];
            if (region.name().replace("_", "").equals(name.replace("-", ""))) {
                return region.yinheRegionValue;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // System.out.println(Regions.getYinheRegionValue("CN-SHANGHAI-2"));
        // getRegionByName();
        System.out.println(Regions.CN_SHANGHAI_2);

        String s = new String(
                "{\"prefixList\":[],\"crrTargetInfo\":{\"targetBucketName\": \"ljm094\",\"region\": \"CN-SHANGHAI-2\",},\"targetBid\":5212736361,\"bucketName\":\"ljm093\",\"deleteMarkerStatus\":\"Disabled\",\"userId\":\"180000000\"}");
        Regions region = Regions.CN_SHANGHAI_2;

        System.out.println(s.replace(region.yinheRegionValue, region.name()));

    }

    public static void getRegionByName() {
        for (Regions region : values()) {
            System.out.println(region);
        }
    }

}
