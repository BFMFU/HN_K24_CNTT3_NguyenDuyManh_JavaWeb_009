package app.product.hackathon.repository.impl;

import app.product.hackathon.model.GameDisk;
import app.product.hackathon.repository.GameDiskRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class GameDiskRepositoryImpl implements GameDiskRepository {
	private final List<GameDisk> gameDisks;
	public GameDiskRepositoryImpl() {
		gameDisks = new ArrayList<GameDisk>();
		gameDisks.add(new GameDisk(1L,"GTA V","Hành Động",10,""));
		gameDisks.add(new GameDisk(2L,"Valorant","FPS",2,""));
		gameDisks.add(new GameDisk(3L,"Mario","Adventure",5,""));
		gameDisks.add(new GameDisk(4L,"God Of War","Adventure",20,""));
		gameDisks.add(new GameDisk(5L,"Fifa 26","Thể Thao",10,""));
	}
	@Override
	public List<GameDisk> getAll() {
		return gameDisks;
	}

	@Override
	public List<GameDisk> getByTitleOrGenre(String key) {
		return gameDisks.stream().filter(gameDisk -> gameDisk.getTitle().contains(key) || gameDisk.getGenre().contains(key)).toList();
	}

	@Override
	public void save(GameDisk gameDisk) {
		gameDisks.add(gameDisk);
	}

	@Override
	public void delete(Long id) {
		gameDisks.removeIf(gameDisk -> gameDisk.getId().equals(id));
	}

	@Override
	public void update(Long id, GameDisk gameDisk) {
	    boolean isExit= gameDisks.stream().anyMatch(g -> g.getId() == id);
		if(isExit){
			for(GameDisk gameDisk1 : gameDisks){
				if(gameDisk1.getId().equals(id)){
					gameDisk1.setTitle(gameDisk.getTitle());
					gameDisk1.setGenre(gameDisk.getGenre());
					gameDisk1.setQuantity(gameDisk.getQuantity());
					gameDisk1.setCoverImage(gameDisk.getCoverImage());
				}
			}
		}
	}


}
