package com.postservice;

import java.time.LocalDateTime;

/**
 * @author Dominik_Janiga
 */
record PostResponseDto(long id, long authorId, String text, LocalDateTime postedAt) {

}
