package com.jeontongju.review.controller;

import com.jeontongju.review.dto.request.CreateReviewDto;
import com.jeontongju.review.service.ReviewService;
import io.github.bitbox.bitbox.dto.ResponseFormat;
import io.github.bitbox.bitbox.enums.MemberRoleEnum;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ReviewRestController {

  private final ReviewService reviewService;

  @PostMapping("/products/reviews")
  public ResponseEntity<ResponseFormat<Void>> createReview(
      @RequestHeader Long memberId,
      @RequestHeader MemberRoleEnum memberRole,
      @Valid @RequestBody CreateReviewDto createReviewDto) {

    reviewService.createReview(memberId, createReviewDto);

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("리뷰 작성 성공")
                .build());
  }

  @PostMapping("/reviews/{reviewId}/sympathy")
  public ResponseEntity<ResponseFormat<Void>> reviewSympathy(
      @RequestHeader Long memberId,
      @RequestHeader MemberRoleEnum memberRole,
      @PathVariable Long reviewId) {

    reviewService.reviewSympathy(memberId, reviewId);

    return ResponseEntity.ok()
        .body(
            ResponseFormat.<Void>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.name())
                .detail("리뷰 공감 상태 변경 성공")
                .build());
  }
}