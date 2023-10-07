package dsa.rkr.trie

object TrieCheck {

  def main(args: Array[String]): Unit = {
    val root = new TrieNode
    val value = "saturn"
    insert(root, value)
    println(root)

    println(search(root, "sat"))
    println(search(root, "sun"))
    println(search(root, "saturn"))

    println(delete(root, "sat"))
    println(delete(root, "saturn"))
    println(search(root, "saturn"))
  }

  def insert(root: TrieNode, value: String) : Unit = {
    var node = root
    for (a <- value.toCharArray) {
      var childNode = node.childNodes(a - 'a')
      if (childNode == null) {
        childNode = new TrieNode
        node.childNodes(a - 'a') = childNode
      }
      node = childNode
    }
    node.wordCount = node.wordCount + 1
  }

  def search(root: TrieNode, value: String): Boolean = {
    var node = root
    for (a <- value.toCharArray) {
      val childNode = node.childNodes(a - 'a')
      if (childNode == null) {
        return false
      }
      node = childNode
    }
    (node != null && node.wordCount > 0)
  }

  def delete(root: TrieNode, value: String): Boolean = {
    var node = root
    for (a <- value.toCharArray) {
      var childNode = node.childNodes(a - 'a')
      if (childNode == null) {
        return false
      }
      node = childNode
    }
    if(node != null && node.wordCount>0) {
      node.wordCount = node.wordCount - 1
      true
    } else {
      false
    }
  }

}

class TrieNode {
  var wordCount : Int = 0
  var childNodes : Array[TrieNode] = new Array[TrieNode](26)
}