package app.product.hackathon.service.impl;

import app.product.hackathon.model.GameDisk;
import app.product.hackathon.repository.GameDiskRepository;
import app.product.hackathon.service.GameDiskService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameDiskServiceImpl implements GameDiskService {
	private final GameDiskRepository gameDiskRepository;
	public GameDiskServiceImpl(GameDiskRepository gameDiskRepository) {
		this.gameDiskRepository = gameDiskRepository;
	}
	@Override
	public List<GameDisk> findAll() {
		return gameDiskRepository.getAll();
	}

	@Override
	public List<GameDisk> findByTitleOrGenre(String key) {
		return gameDiskRepository.getByTitleOrGenre(key);
	}
	@Override
	public void addGameDisk(GameDisk gameDisk) {
		gameDiskRepository.save(gameDisk);
	}

	@Override
	public void deleteGameDisk(Long id) {
		gameDiskRepository.delete(id);
	}
	@Override
	public void updateGameDisk(Long id, GameDisk gameDisk) {
		gameDiskRepository.update(id, gameDisk);
	}
}
