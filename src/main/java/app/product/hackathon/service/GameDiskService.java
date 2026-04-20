package app.product.hackathon.service;

import app.product.hackathon.model.GameDisk;

import java.util.List;

public interface GameDiskService {
	List<GameDisk> findAll();
	List<GameDisk> findByTitleOrGenre(String key);
	void addGameDisk(GameDisk gameDisk);
	void deleteGameDisk(Long id);
	void updateGameDisk(Long id, GameDisk gameDisk);
}
