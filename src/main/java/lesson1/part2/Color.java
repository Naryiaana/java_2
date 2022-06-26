package lesson1.part2;

public enum Color {
    BLACK("черный"),
    WHITE("белый"),
    RED("рыжий"),
    GREY("серый");
    /*PLUS("плюс") {
        @Override
        void action(double a, double b) {
            System.out.println(a + b);
        }
    }*/

    private String russianColor;

    Color(String russianColor) {
        this.russianColor = russianColor;
    }

    public String getRussianColor() {
        return russianColor;
    }

    public String getEnglishColor() {
        return name().toLowerCase();
    }

    //abstract void action(double a, double b);
}

