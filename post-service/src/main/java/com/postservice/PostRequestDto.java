package com.postservice;

/**
 * @author Dominik_Janiga
 */
record PostRequestDto(long authorId, String topic, String text) {

    Post toPost() {
        return new Post(authorId, topic, text);
    }
}
