package com.postservice;

import java.time.LocalDate;

/**
 * @author Dominik_Janiga
 */
record PostResponseDto(long id, long authorId, String text, LocalDate postedAt) {

}
