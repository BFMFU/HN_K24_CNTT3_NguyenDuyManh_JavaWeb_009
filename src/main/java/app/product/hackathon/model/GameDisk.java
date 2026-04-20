package app.product.hackathon.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Valid
public class GameDisk {
	@NotNull(message = "Id không được để trống")
	private Long id;
	@NotEmpty(message = "Title không được để trống")
	@Size(min =3, max=100, message = "Title phải có từ 3 đến 100 ký tự")
	private String title;
	@NotBlank(message = "Genre không được để trống")
	@Size(min =3, message = "Genre phải có ít nhất 3 ký tự")
	private String genre;
	@NotNull(message = "Quantity không được để trống")
	@Size(min =0, message = "Quantity không được âm")
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
