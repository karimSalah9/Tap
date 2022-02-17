package task.tap.payment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import task.tap.payment.model.entity.dto.TopupDTO;
import task.tap.payment.model.paylod.TopupRequest;
import task.tap.payment.service.TopupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topup")
public class TopopController {

	private final TopupService topupService;

	@PostMapping
	public TopupDTO topup(@RequestBody TopupRequest topupRequest) {

		try {
			return topupService.topup(topupRequest);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
