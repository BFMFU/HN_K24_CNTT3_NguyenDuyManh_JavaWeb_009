package app.product.hackathon.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Valid
public class GameDisk {
	@NotNull
	private Long id;
	@NotEmpty
	@Size(min =3, max=100)
	private String title;
	@NotBlank
	@Size(min =3)
	private String genre;
	@NotNull
	@Size(min =0)
	private Integer quantity;
	private String coverImage;

	public GameDisk() {
	}

	public GameDisk(Long id, String title, String genre, Integer quantity, String coverImage) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.quantity = quantity;
		this.coverImage = coverImage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
}
