package com.example.hogwarts.utils

fun <X : BaseViewHolderModel<X>> assignViewHolderType(
    arrayList: ArrayList<X>,
    viewHolderType: ViewHolderType
): ArrayList<X> {
    val tempArrayList = ArrayList<X>()
    for (listItem in arrayList) {
        listItem.modelType = viewHolderType
        tempArrayList.add(listItem)
    }
    return tempArrayList
}
