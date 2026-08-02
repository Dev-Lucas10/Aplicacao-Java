package br.edu.programacaoavancada.catalogo;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(Long id) {
        super("Produto não encontrado com id: " + id);
    }
}
