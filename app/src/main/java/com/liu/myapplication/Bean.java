package com.liu.myapplication;

import java.util.List;

public class Bean {
    /**
     * list : [{"name":"感冒用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18135.png"},{"name":"心脑血管用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18149.png"},{"name":"胃肠用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18147.png"},{"name":"风湿骨伤用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18132.png"},{"name":"止咳化痰平喘药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18151.png"},{"name":"清热药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18143.png"},{"name":"五官科用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18148.png"},{"name":"滋补营养药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18152.png"},{"name":"儿科用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18131.png"},{"name":"妇科用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18133.png"},{"name":"皮肤用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18141.png"},{"name":"泌尿系统用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18140.png"},{"name":"肝胆用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18134.png"},{"name":"血液系统用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18150.png"},{"name":"激素和内分泌用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18136.png"},{"name":"解热镇痛抗炎药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18137.png"},{"name":"神经系统用药","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18144.png"}]
     * name : 中成药
     * isBoolean : false
     */

    private String name;
    private boolean isBoolean;
    private List<ListBean> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsBoolean() {
        return isBoolean;
    }

    public void setIsBoolean(boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * name : 感冒用药
         * imgsrc : https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_18_18135.png
         */

        private String name;
        private String imgsrc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
