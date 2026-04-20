package app.product.hackathon.controller;

import app.product.hackathon.model.GameDisk;
import app.product.hackathon.service.GameDiskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	@GetMapping("form")
	public String toForm(Model model) {
		model.addAttribute("gameDisk", new GameDisk());
		return "game-disk-add";
	}
	@GetMapping("edit/{id}")
	public String editForm(@PathVariable Long id, Model model) {
		GameDisk gameDisk = gameDiskService.findById(id);
		if (gameDisk != null) {
			model.addAttribute("gameDisk", gameDisk);
		} else {
			model.addAttribute("gameDisk", new GameDisk());
		}
		return "game-disk-add";
	}
	@PostMapping("add")
	public String addGameDisk(@Valid @ModelAttribute GameDisk gameDisk, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "game-disk-add";
		}
		gameDiskService.addGameDisk(gameDisk);
		return "redirect:/gameDisk";
	}
	@PostMapping("update/{id}")
	public String updateGameDisk(@PathVariable Long id, @Valid @ModelAttribute GameDisk gameDisk, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("gameDisk", gameDisk);
			return "game-disk-add";
		}
		gameDiskService.updateGameDisk(id, gameDisk);
		return "redirect:/gameDisk";
	}
	@GetMapping("delete/{id}")
	public String deleteGameDisk(@PathVariable Long id) {
		gameDiskService.deleteGameDisk(id);
		return "redirect:/gameDisk";
	}
}
