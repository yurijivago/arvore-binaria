package com.yurijivago;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T>  novoNo){
        if(atual == null){
            return novoNo;
        } else if(novoNo.getContent().compareTo(atual.getContent()) < 0) {
            atual.setNoLeft(inserir(atual.getNoLeft(), novoNo));
        } else {
            atual.setNoRight(inserir(atual.getNoRight(), novoNo));
        }
        return atual;
    }

}
