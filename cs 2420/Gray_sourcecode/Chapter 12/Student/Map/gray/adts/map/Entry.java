package gray.adts.map;

public class Entry<K, V> implements java.io.Serializable {
  private K key;
  private V value;

  public Entry() {
    key = null;
    value = null;
  }

  /**
   * Create an entry for key <code>k</code> and value <code>v</code>.
   * @param k the key for this entry
   * @param v the value associated with key <code>k</code>
   *    for this entry
   * @throws <IllegalArgumentException> if either <code>k</code> or
   *    <code>v</code> is <code>null</code>
   */
  public Entry( K k, V v ) {
    if ( ( k == null ) || ( v == null ) ) {
      throw new IllegalArgumentException( "null argument " );
    }
    this.key = k;
    this.value = v;
  }

  /**
   * Return the <code>key</code> for this entry.
   * @return the <code>key</code> for this entry
   */
  public K key() {
    return this.key;
  }

  /**
   * Return the <code>value</code> for this entry.
   * @return the <code>value</code> for this entry
   */
  public V value() {
    return this.value;
  }

  /**
   * Set the <code>value</code> field for this entry to
   *  <code>newValue</code>.
   * @param newValue the new value for this entry
   * @return the old <code>value</code> for this entry
   */
  public V setValue( V newValue ) {
    if ( newValue == null ) {
      throw new IllegalArgumentException( "null argument " );
    }
    V tempValue = this.value;
    this.value = newValue;
    return tempValue;
  }

  /**
   * Overridden method from <code>Object</Code>.
   * @return <code>String</code> representation of this entry.
   */
  public String toString() {
    return "Key: " + this.key + "\nValue: " + this.value;
  }

}
