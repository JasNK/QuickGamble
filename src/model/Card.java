package model;

public class Card {
    private String code;
    private String image;
    private final Images images;
    private String value;
    private String suit;

    public Card(String code, String image, Images images, String value, String suit) {
        this.code = code;
        this.image = image;
        this.images = images;
        this.value = value;
        this.suit = suit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public static class Images {
        private String svg;
        private String png;

        public Images(String svg, String png) {
            this.svg = svg;
            this.png = png;
        }

        public String getSvg() {
            return svg;
        }

        public void setSvg(String svg) {
            this.svg = svg;
        }

        public String getPng() {
            return png;
        }

        public void setPng(String png) {
            this.png = png;
        }
    }

}
