package com.nangokuman.databindingrecycleviewsample

class MainListViewModel {

    var listItems: List<ListItem> = listOf(
        ListItem.CaptionItem("AV・情報家電"),
        ListItem.SubCaptionItem("映像関連"),
        ListItem.CategoryItem("液晶テレビ"),
        ListItem.CategoryItem("プラズマテレビ"),
        ListItem.CategoryItem("液晶保護フィルム"),
        ListItem.CategoryItem("テレビリモコン"),
        ListItem.CategoryItem("テレビオプション"),
        ListItem.CaptionItem("AV・情報家電"),
        ListItem.SubCaptionItem("映像関連"),
        ListItem.CategoryItem("液晶テレビ"),
        ListItem.CategoryItem("プラズマテレビ"),
        ListItem.CategoryItem("液晶保護フィルム"),
        ListItem.CategoryItem("テレビリモコン"),
        ListItem.CategoryItem("テレビオプション"),
        ListItem.CaptionItem("AV・情報家電"),
        ListItem.SubCaptionItem("映像関連"),
        ListItem.CategoryItem("液晶テレビ"),
        ListItem.CategoryItem("プラズマテレビ"),
        ListItem.CategoryItem("液晶保護フィルム"),
        ListItem.CategoryItem("テレビリモコン"),
        ListItem.CategoryItem("テレビオプション"),
        ListItem.CaptionItem("AV・情報家電"),
        ListItem.SubCaptionItem("映像関連"),
        ListItem.CategoryItem("液晶テレビ"),
        ListItem.CategoryItem("プラズマテレビ"),
        ListItem.CategoryItem("液晶保護フィルム"),
        ListItem.CategoryItem("テレビリモコン"),
        ListItem.CategoryItem("テレビオプション")
    )
    sealed class ListItem {
        abstract fun getType(): Type
        enum class Type(val id: Int) {
            Caption(10),
            SubCaption(20),
            Category(30),
            ;

            companion object {
                fun from(id: Int): Type {
                    return values().first{ it.id == id }
                }
            }
        }

        class CaptionItem(val title: String): ListItem() {
            override fun getType(): Type {
                return Type.Caption
            }
        }

        class SubCaptionItem(val title: String): ListItem() {
            override fun getType(): Type {
                return Type.SubCaption
            }
        }

        class CategoryItem(val title: String): ListItem() {
            override fun getType(): Type {
                return Type.Category
            }
        }
    }
}