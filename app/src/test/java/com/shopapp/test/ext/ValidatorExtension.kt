package com.shopapp.test.ext

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.shopapp.domain.validator.FieldValidator

fun FieldValidator.mock() {
    given(isEmailValid(any())).willReturn(true)
    given(isPasswordValid(any())).willReturn(true)
    given(isAddressValid(any())).willReturn(true)
}