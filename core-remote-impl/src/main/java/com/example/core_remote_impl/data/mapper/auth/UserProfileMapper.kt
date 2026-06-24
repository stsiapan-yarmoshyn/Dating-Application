package com.example.core_remote_impl.data.mapper.auth

import com.example.core_backendless_api.model.Payload
import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_remote_impl.data.model.auth.BackendlessRef
import com.example.core_remote_impl.data.model.auth.TransactionOperation
import com.example.core_remote_impl.data.model.auth.TransactionRequest
import com.example.core_remote_impl.data.model.auth.payloads.PhotoPayload
import com.example.core_remote_impl.data.model.auth.payloads.RelationPayload
import com.example.core_remote_impl.data.model.auth.payloads.UserPayload

const val USER_TABLE = "Users"
const val PHOTO_TABLE = "user_photo"
const val USER_OP_RESULT = "newUserResult"
const val PHOTOS_OP_RESULT = "bulkPhotosResult"
const val RELATION_COLUMN = "photos"


fun UserProfileModel.toTransactionRequest(): TransactionRequest {
    val userTransaction = createUserPayload(this).coverWithOperation(
        opType = TransactionOperation.OPERATION_TYPE_CREATE,
        opResult = USER_OP_RESULT,
        tableName = USER_TABLE,
    )

    val photoRefsList = mutableListOf<BackendlessRef>()

    val photoTransaction = createPhotoPayload(this.photos).coverWithOperation(
        opType = TransactionOperation.OPERATION_TYPE_CREATE_BULK,
        opResult = PHOTOS_OP_RESULT,
        tableName = PHOTO_TABLE,
    ).also {
        it.payloadList?.forEachIndexed { index, payload ->
            photoRefsList.add(
                BackendlessRef(opResultId = PHOTOS_OP_RESULT, resultIndex = index)
            )
        }
    }
    val relationTransaction = createRelationPayload(photoRefsList).coverWithOperation(
        opType = TransactionOperation.OPERATION_TYPE_SET_RELATION,
        tableName = USER_TABLE,
    )
    return TransactionRequest(
        operations = listOf(userTransaction, photoTransaction, relationTransaction)
    )
}

private fun Payload.coverWithOperation(
    opResult: String? = null,
    opType: String,
    tableName: String
): TransactionOperation {
    return TransactionOperation(
        operationType = opType,
        table = tableName,
        opResultId = opResult,
        payload = this,
    )
}

private fun List<Payload>.coverWithOperation(
    opResult: String,
    opType: String,
    tableName: String
): TransactionOperation {
    return TransactionOperation(
        operationType = opType,
        table = tableName,
        opResultId = opResult,
        payloadList = this,
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

private fun createPhotoPayload(photos: List<PhotoModel>): List<PhotoPayload> {
    return photos.mapIndexed { index, photoModel ->
        PhotoPayload(
            photoUrl = photoModel.photoUrl,
            orderIndex = index,
        )
    }
}

private fun createRelationPayload(photoRefsList: List<BackendlessRef>): RelationPayload {
    return RelationPayload(
        parentObject = BackendlessRef(opResultId = USER_OP_RESULT, propName = BackendlessRef.DEFAULT_PROP_NAME),
        relationColumn = RELATION_COLUMN,
        unconditionalList = photoRefsList
    )
}


