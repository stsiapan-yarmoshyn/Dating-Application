package com.example.core_remote_impl.data.mapper.auth

import com.example.core_backendless_api.model.Payload
import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_remote_impl.data.model.auth.TransactionOperation
import com.example.core_remote_impl.data.model.auth.TransactionRequest
import com.example.core_remote_impl.data.model.auth.payloads.PhotoPayload
import com.example.core_remote_impl.data.model.auth.payloads.RelationPayload
import com.example.core_remote_impl.data.model.auth.payloads.UserPayload

fun UserProfileModel.toTransactionRequest(): TransactionRequest {
    val photoPayload = createPhotoPayload(this.photos)
    val userPayload = createUserPayload(this).coverWithOperation(
        opResult = TransactionOperation.OPERATION_TYPE_CREATE,
        opType = "newUserResult",
        tableName = "Users"
    )
    val relationPayload = createRelationPayload(this)
}

private fun Payload.coverWithOperation(opResult: String, opType: String, tableName: String): TransactionOperation {
    return TransactionOperation(
        operationType = opResult,
        table = tableName,
        opResultId = opResult,
        payload = this
    )
}
private fun createUserPayload(userProfileModel: UserProfileModel): UserPayload {
    return UserPayload(
        password = userProfileModel.password,
        email = userProfileModel.email,
        gender = userProfileModel.gender,
        birthDate = userProfileModel.birthDate,
        bio = userProfileModel.bio,
        searchGender = userProfileModel.searchGender,
        name = userProfileModel.name,
    )
}

private fun createRelationPayload(userProfileModel: UserProfileModel): RelationPayload {

}

private fun createPhotoPayload(photoList: List<PhotoModel>): PhotoPayload {

}

