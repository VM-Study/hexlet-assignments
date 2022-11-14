package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    private String text;

    public ReversedSequence(String text) {
        this.text = revers(text);
    }

    private String revers(String text) {
        String reversText = "";
        for (int r = text.length() - 1; r >= 0; r--) {
            reversText += text.charAt(r);
        }
        return reversText;
    }


    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return text.subSequence(start, end);
    }

    @Override
    public String toString() {
        return text;
    }
}

// END
