package com.oxuegen.securitybank.controller;

import java.time.Duration;
import java.util.List;

import com.oxuegen.securitybank.model.Notice;
import com.oxuegen.securitybank.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoticesController {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@GetMapping("/notices")
	public ResponseEntity<List<Notice>> getNotices() {
		List<Notice> notices = noticeRepository.findAllActiveNotices();
		if (notices != null ) {
			return ResponseEntity.ok()
					.cacheControl(CacheControl.maxAge(Duration.ofSeconds(60)))
					.body(notices);
		}else {
			return null;
		}
	}

}
