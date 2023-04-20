package com.postservice;

/**
 * @author Dominik_Janiga
 */
record PostRequestDto(long authorId, String text) {

    Post toPost() {
        return new Post(authorId, text);
    }
}
