package com.yukoon.midautumnquiz.repo;

import com.yukoon.midautumnquiz.entities.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuzzleRepo extends JpaRepository<Puzzle,Integer>{
}
