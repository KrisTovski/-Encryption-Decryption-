package encryptdecrypt;

enum Action {
    ENCRYPT("enc"),
    DECRYPT("dec");

    String description;

    Action(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Action findByValue(String dec) {
        for (Action value : values()) {
            if (dec.equals(value.description)) {
                return value;
            }
        }
        return null;
    }

}
