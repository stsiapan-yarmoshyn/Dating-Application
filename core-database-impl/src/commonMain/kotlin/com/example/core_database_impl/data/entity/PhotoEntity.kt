package com.example.core_database_impl.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.core_database_impl.data.entity.relation.UserWithPhotos

@Entity(
    tableName = PhotoEntity.PHOTO_TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = UserProfileEntity::class,
            parentColumns = [UserWithPhotos.PARENT_COLUMN],
            childColumns = [UserWithPhotos.CHILD_COLUMN],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
internal data class PhotoEntity(
    @PrimaryKey val photoId: String,
    val photoUrl: String,
    val photoNumber: Int,
    val userCreatorId: String,
) {
    companion object {
        const val PHOTO_TABLE_NAME = "photo_table"
    }
}