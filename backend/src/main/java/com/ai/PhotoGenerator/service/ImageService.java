package com.ai.PhotoGenerator.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImageService {
    private final OpenAiImageModel openAiImageModel;


    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    public ImageResponse generateImage(String prompt, String quality, int width, int height) throws IOException {
        ImageResponse imageResponse = openAiImageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .model("dall-e-3")
                                .quality(quality)
                                .N(1  )
                                .height(height)
                                .width(width)
                                .build()
                )
        );
          return imageResponse;
    }
}
