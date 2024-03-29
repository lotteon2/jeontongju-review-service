package com.jeontongju.review.dto.request;

import com.jeontongju.review.enums.ConceptTypeEnum;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CreateReviewDto {

  @NotNull(message = "null 이 불가합니다.")
  private String productId;

  @NotNull(message = "null 이 불가합니다.")
  private Long productOrderId;

  @NotBlank(message = "null 이 불가합니다.")
  private String reviewContents;

  private String reviewPhotoImageUrl;

  private List<ConceptTypeEnum> concept;
}
