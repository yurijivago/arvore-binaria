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
        System.out.println("\nExibindo InOrdem");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(BinNo<T> atual){
        if (atual != null){
            exibirInOrdem(atual.getNoLeft());
            System.out.print(atual.getContent() + ", ");
            exibirInOrdem(atual.getNoRight());
        }
    }

    //PosOrdem
    public void exibirPosOrdem(){
        System.out.println("\nExibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual){
        if (atual != null){
            exibirPosOrdem(atual.getNoLeft());
            exibirPosOrdem(atual.getNoRight());
            System.out.print(atual.getContent() + ", ");
        }
    }

    //PreOrdem
    public void exibirPreOrdem(){
        System.out.println("\nExibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual){
        if (atual != null){
            System.out.print(atual.getContent() + ", ");
            exibirPreOrdem(atual.getNoLeft());
            exibirPreOrdem(atual.getNoRight());
        }
    }


    //Método remover
    public void remover(T conteudo){
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while(atual != null && !atual.getContent().equals(conteudo)){
                pai = atual;
                if(conteudo.compareTo(atual.getContent()) < 0){
                    atual = atual.getNoLeft();
                } else {
                    atual = atual.getNoRight();
                }
            }

            //Se não encontrar ninguém: ou atingimos uma folha ou a raiz é null
            if(atual == null){
                System.out.println("Conteudo nao encontrado. Bloco Try");
            }

            //verificando se o pai é nulo, se o atual.direito é null, se o atual.esquerda é null;
            if(pai == null) {
                if(atual.getNoRight() == null){
                    //se o atual.direito é null, pegamos o atual.esquerda
                    this.raiz = atual.getNoLeft();
                } else if (atual.getNoLeft() == null){
                    //caso contrário, pegamos o atual.direita
                    this.raiz = atual.getNoRight();
                } else {
                    for(temp = atual, filho = atual.getNoLeft();
                        filho.getNoRight() != null;
                        temp = filho, filho = filho.getNoLeft()){

                        if(filho != atual.getNoLeft()){
                            temp.setNoRight(filho.getNoLeft());
                            filho.setNoLeft(raiz.getNoLeft());
                        }

                        filho.setNoRight(raiz.getNoRight());
                        raiz = filho;
                    }
                }

            } else if(atual.getNoRight() == null) {
                if(pai.getNoLeft() == atual){
                    pai.setNoLeft(atual.getNoLeft());
                } else {
                    pai.setNoRight(atual.getNoLeft());
                }

            } else if(atual.getNoLeft() == null) {
                if(pai.getNoLeft() == atual){
                    pai.setNoLeft(atual.getNoRight());
                } else {
                    pai.setNoRight(atual.getNoRight());
                }
            } else {
                for(temp = atual, filho = atual.getNoLeft();
                filho.getNoRight() != null;
                temp = filho, filho = filho.getNoRight()){
                    if(filho != atual.getNoLeft()){
                        temp.setNoRight(filho.getNoLeft());
                        filho.setNoLeft(atual.getNoLeft());
                    }

                    filho.setNoRight(atual.getNoRight());

                    if(pai.getNoLeft() == atual){
                        pai.setNoLeft(filho);
                    } else {
                        pai.setNoRight(filho);
                    }
                }
            }


        } catch(NullPointerException erro){
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }
    }

}
