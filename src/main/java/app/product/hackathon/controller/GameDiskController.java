package app.product.hackathon.controller;

import app.product.hackathon.model.GameDisk;
import app.product.hackathon.service.GameDiskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/","/gameDisk"})
public class GameDiskController {
	private final GameDiskService gameDiskService;
	public GameDiskController(GameDiskService gameDiskService) {
		this.gameDiskService = gameDiskService;
	}
	@GetMapping()
	public String gameDisk(Model model) {
		model.addAttribute("gameDisks", gameDiskService.findAll());
		return "game-disk-list";
	}
	@GetMapping("gameDisk/form")
	public String toForm(Model model) {
		model.addAttribute("gameDisk", new GameDisk());
		return "game-disk-add";
	}
	@PostMapping("add")
	public String addGameDisk(Model model,@RequestParam GameDisk gameDisk) {
		gameDiskService.addGameDisk(gameDisk);
		model.addAttribute("gameDisks", gameDiskService.findAll());
		return "game-disk-list";
	}
	@GetMapping("delete/id={}")
	public String deleteGameDisk(@PathVariable Long id, Model model) {
		gameDiskService.deleteGameDisk(id);
		model.addAttribute("gameDisks", gameDiskService.findAll());
		return "game-disk-list";
	}
}
