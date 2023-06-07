package br.com.alura.screenmatch.domain.filmes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme,Long> {
}
