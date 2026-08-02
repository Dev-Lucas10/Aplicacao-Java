package br.edu.programacaoavancada.catalogo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(3);

    public ProdutoService() {
        produtos.add(new Produto(1L, "Notebook", 3500.00, 5));
        produtos.add(new Produto(2L, "Mouse sem fio", 120.00, 10));
    }

    public List<Produto> listar() {
        return produtos;
    }

    public Produto buscarPorId(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    public Produto cadastrar(Produto produto) {
        produto.setId(proximoId.getAndIncrement());
        produtos.add(produto);
        return produto;
    }
}
