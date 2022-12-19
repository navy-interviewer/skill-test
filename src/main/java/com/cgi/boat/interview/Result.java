package com.cgi.boat.interview;

public class Result {

    private String value;
    private int count;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Result{" +
                "value='" + value + '\'' +
                ", count=" + count +
                '}';
    }

    public static class Builder {
        private String value;
        private int count;

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder count(int count) {
            this.count = count;
            return this;
        }

        public Result build() {
            Result result = new Result();
            result.setValue(value);
            result.setCount(count);
            return result;
        }
    }
}
