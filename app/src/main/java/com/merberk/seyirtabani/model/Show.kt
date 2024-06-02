package com.merberk.seyirtabani.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "countries")
data class Show(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id") // JSON'dan gelen id ile eşleştirildi
    val id: Int,
    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    val originalTitle: String?,
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val posterPath: String,
    @ColumnInfo(name = "media_type")
    @SerializedName("media_type")
    val mediaType: String,
    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    val adult: Boolean,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String?,
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "genre_ids")
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    val popularity: Double,
    @ColumnInfo(name = "first_air_date")
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    val voteCount: Int,
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "video")
    @SerializedName("video")
    val video: Boolean
) : Parcelable
