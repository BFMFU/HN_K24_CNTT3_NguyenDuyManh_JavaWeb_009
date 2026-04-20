package app.product.hackathon.repository;

import app.product.hackathon.model.GameDisk;

import java.util.List;

public interface GameDiskRepository {
	List<GameDisk> getAll();
	List<GameDisk> getByTitleOrGenre(String key);
	void save(GameDisk gameDisk);
	void delete(Long id);
	void update(Long id, GameDisk gameDisk);
}
