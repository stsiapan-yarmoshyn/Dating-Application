package com.example.core_database_impl.data.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.core_database_impl.data.entity.PhotoEntity
import com.example.core_database_impl.data.entity.UserProfileEntity


data class UserWithPhotos(
    @Embedded val user: UserProfileEntity,
    @Relation(
        parentColumn = PARENT_COLUMN,
        entityColumn = CHILD_COLUMN
    )
    val photos: List<PhotoEntity>
) {
    companion object {
        const val PARENT_COLUMN = "userId"
        const val CHILD_COLUMN = "userCreatorId"
    }
}
