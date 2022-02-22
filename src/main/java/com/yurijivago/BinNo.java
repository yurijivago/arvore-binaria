package com.yurijivago;

public class BinNo <T extends Comparable<T>>{
    private T content;
    private BinNo<T> noLeft;
    private BinNo<T> noRight;

    public BinNo(T content) {
        this.content = content;
        noLeft = noRight = null;
    }

    public BinNo() {}

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public BinNo<T> getNoLeft() {
        return noLeft;
    }

    public void setNoLeft(BinNo<T> noLeft) {
        this.noLeft = noLeft;
    }

    public BinNo<T> getNoRight() {
        return noRight;
    }

    public void setNoRight(BinNo<T> noRight) {
        this.noRight = noRight;
    }

    @Override
    public String toString() {
        return "BinNo{" +
                "content=" + content +
                '}';
    }
}
