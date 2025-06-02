package org.sergeantKoala.service.comparisionStrategies;

import org.sergeantKoala.service.ComparisonStrategy;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TextContentStrategy implements ComparisonStrategy<String> {
    @Override
    public String extractComparable(String url) {
        try {
            String html = new String(new URL(url).openStream().readAllBytes(), StandardCharsets.UTF_8);
            return html.replaceAll("<[^>]*>", "").replaceAll("\\s+", " ").trim();
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch content for URL: " + url, e);
        }
    }

    @Override
    public boolean isSame(String oldValue, String newValue) {
        return oldValue.equals(newValue);
    }
}
