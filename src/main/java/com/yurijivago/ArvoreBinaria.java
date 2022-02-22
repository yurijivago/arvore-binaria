package com.yurijivago;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    //Métodos de inserção
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

    //Métodos de exibição
    //InOrdem
    public void exibirInOrdem(){
        System.out.println("Exibindo InOrdem");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(BinNo<T> atual){
        if (atual != null){
            exibirInOrdem(atual.getNoLeft());
            System.out.println(atual.getContent() + ", ");
            exibirInOrdem(atual.getNoRight());
        }
    }

    //PosOrdem
    public void exibirPosOrdem(){
        System.out.println("Exibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual){
        if (atual != null){
            exibirPosOrdem(atual.getNoLeft());
            exibirPosOrdem(atual.getNoRight());
            System.out.println(atual.getContent() + ", ");
        }
    }

    //PreOrdem
    public void exibirPreOrdem(){
        System.out.println("Exibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual){
        if (atual != null){
            System.out.println(atual.getContent() + ", ");
            exibirPreOrdem(atual.getNoLeft());
            exibirPreOrdem(atual.getNoRight());
        }
    }

}
