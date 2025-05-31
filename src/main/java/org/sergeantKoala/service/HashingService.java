package org.sergeantKoala.service;

import org.sergeantKoala.model.Website;
import org.sergeantKoala.repository.WebsiteRepository;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashingService {

    private static HashingService instance;


    // keep constructor private to prevent direct instantiation


    public static String hashWebsite(String url) {
        try {
            // Step 1: Fetch website HTML content
            String content = fetchContent(url);

            // Step 2: Filter out some dynamic content (moderate stripping)
            content = stripDynamicContent(content); // 👈 This still removes most noise

            // Step 3: Hash using SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(content.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);

        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String fetchContent(String url) throws IOException {
        try (Scanner scanner = new Scanner(new URL(url).openStream(), StandardCharsets.UTF_8)) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    private static String stripDynamicContent(String html) {
        // Remove scripts (usually dynamic)
        html = html.replaceAll("(?is)<script[^>]*>.*?</script>", "");

        // Remove inline styles (often injected)
        html = html.replaceAll("(?is)<style[^>]*>.*?</style>", "");

        // Remove meta tags (tracking, timestamps, etc.)
        html = html.replaceAll("(?i)<meta[^>]*>", "");

        // Remove comments
        html = html.replaceAll("(?s)<!--.*?-->", "");

        // Leave <head> and <body> intact for now to preserve structure
        // Don't remove tags entirely — just normalize whitespace
        html = html.replaceAll("\\s+", " ").trim();

        return html;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}
