/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package types;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class DeliveryAddress extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5027845524295126990L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DeliveryAddress\",\"namespace\":\"types\",\"fields\":[{\"name\":\"AddressLine\",\"type\":[\"null\",\"string\"]},{\"name\":\"City\",\"type\":[\"null\",\"string\"]},{\"name\":\"State\",\"type\":[\"null\",\"string\"]},{\"name\":\"PinCode\",\"type\":[\"null\",\"string\"]},{\"name\":\"ContactNumber\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<DeliveryAddress> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<DeliveryAddress> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<DeliveryAddress> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<DeliveryAddress> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<DeliveryAddress> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this DeliveryAddress to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a DeliveryAddress from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a DeliveryAddress instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static DeliveryAddress fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence AddressLine;
  private java.lang.CharSequence City;
  private java.lang.CharSequence State;
  private java.lang.CharSequence PinCode;
  private java.lang.CharSequence ContactNumber;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public DeliveryAddress() {}

  /**
   * All-args constructor.
   * @param AddressLine The new value for AddressLine
   * @param City The new value for City
   * @param State The new value for State
   * @param PinCode The new value for PinCode
   * @param ContactNumber The new value for ContactNumber
   */
  public DeliveryAddress(java.lang.CharSequence AddressLine, java.lang.CharSequence City, java.lang.CharSequence State, java.lang.CharSequence PinCode, java.lang.CharSequence ContactNumber) {
    this.AddressLine = AddressLine;
    this.City = City;
    this.State = State;
    this.PinCode = PinCode;
    this.ContactNumber = ContactNumber;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return AddressLine;
    case 1: return City;
    case 2: return State;
    case 3: return PinCode;
    case 4: return ContactNumber;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: AddressLine = (java.lang.CharSequence)value$; break;
    case 1: City = (java.lang.CharSequence)value$; break;
    case 2: State = (java.lang.CharSequence)value$; break;
    case 3: PinCode = (java.lang.CharSequence)value$; break;
    case 4: ContactNumber = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'AddressLine' field.
   * @return The value of the 'AddressLine' field.
   */
  public java.lang.CharSequence getAddressLine() {
    return AddressLine;
  }


  /**
   * Sets the value of the 'AddressLine' field.
   * @param value the value to set.
   */
  public void setAddressLine(java.lang.CharSequence value) {
    this.AddressLine = value;
  }

  /**
   * Gets the value of the 'City' field.
   * @return The value of the 'City' field.
   */
  public java.lang.CharSequence getCity() {
    return City;
  }


  /**
   * Sets the value of the 'City' field.
   * @param value the value to set.
   */
  public void setCity(java.lang.CharSequence value) {
    this.City = value;
  }

  /**
   * Gets the value of the 'State' field.
   * @return The value of the 'State' field.
   */
  public java.lang.CharSequence getState() {
    return State;
  }


  /**
   * Sets the value of the 'State' field.
   * @param value the value to set.
   */
  public void setState(java.lang.CharSequence value) {
    this.State = value;
  }

  /**
   * Gets the value of the 'PinCode' field.
   * @return The value of the 'PinCode' field.
   */
  public java.lang.CharSequence getPinCode() {
    return PinCode;
  }


  /**
   * Sets the value of the 'PinCode' field.
   * @param value the value to set.
   */
  public void setPinCode(java.lang.CharSequence value) {
    this.PinCode = value;
  }

  /**
   * Gets the value of the 'ContactNumber' field.
   * @return The value of the 'ContactNumber' field.
   */
  public java.lang.CharSequence getContactNumber() {
    return ContactNumber;
  }


  /**
   * Sets the value of the 'ContactNumber' field.
   * @param value the value to set.
   */
  public void setContactNumber(java.lang.CharSequence value) {
    this.ContactNumber = value;
  }

  /**
   * Creates a new DeliveryAddress RecordBuilder.
   * @return A new DeliveryAddress RecordBuilder
   */
  public static types.DeliveryAddress.Builder newBuilder() {
    return new types.DeliveryAddress.Builder();
  }

  /**
   * Creates a new DeliveryAddress RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DeliveryAddress RecordBuilder
   */
  public static types.DeliveryAddress.Builder newBuilder(types.DeliveryAddress.Builder other) {
    if (other == null) {
      return new types.DeliveryAddress.Builder();
    } else {
      return new types.DeliveryAddress.Builder(other);
    }
  }

  /**
   * Creates a new DeliveryAddress RecordBuilder by copying an existing DeliveryAddress instance.
   * @param other The existing instance to copy.
   * @return A new DeliveryAddress RecordBuilder
   */
  public static types.DeliveryAddress.Builder newBuilder(types.DeliveryAddress other) {
    if (other == null) {
      return new types.DeliveryAddress.Builder();
    } else {
      return new types.DeliveryAddress.Builder(other);
    }
  }

  /**
   * RecordBuilder for DeliveryAddress instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DeliveryAddress>
    implements org.apache.avro.data.RecordBuilder<DeliveryAddress> {

    private java.lang.CharSequence AddressLine;
    private java.lang.CharSequence City;
    private java.lang.CharSequence State;
    private java.lang.CharSequence PinCode;
    private java.lang.CharSequence ContactNumber;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(types.DeliveryAddress.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.AddressLine)) {
        this.AddressLine = data().deepCopy(fields()[0].schema(), other.AddressLine);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.City)) {
        this.City = data().deepCopy(fields()[1].schema(), other.City);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.State)) {
        this.State = data().deepCopy(fields()[2].schema(), other.State);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.PinCode)) {
        this.PinCode = data().deepCopy(fields()[3].schema(), other.PinCode);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.ContactNumber)) {
        this.ContactNumber = data().deepCopy(fields()[4].schema(), other.ContactNumber);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing DeliveryAddress instance
     * @param other The existing instance to copy.
     */
    private Builder(types.DeliveryAddress other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.AddressLine)) {
        this.AddressLine = data().deepCopy(fields()[0].schema(), other.AddressLine);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.City)) {
        this.City = data().deepCopy(fields()[1].schema(), other.City);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.State)) {
        this.State = data().deepCopy(fields()[2].schema(), other.State);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.PinCode)) {
        this.PinCode = data().deepCopy(fields()[3].schema(), other.PinCode);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ContactNumber)) {
        this.ContactNumber = data().deepCopy(fields()[4].schema(), other.ContactNumber);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'AddressLine' field.
      * @return The value.
      */
    public java.lang.CharSequence getAddressLine() {
      return AddressLine;
    }


    /**
      * Sets the value of the 'AddressLine' field.
      * @param value The value of 'AddressLine'.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder setAddressLine(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.AddressLine = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'AddressLine' field has been set.
      * @return True if the 'AddressLine' field has been set, false otherwise.
      */
    public boolean hasAddressLine() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'AddressLine' field.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder clearAddressLine() {
      AddressLine = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'City' field.
      * @return The value.
      */
    public java.lang.CharSequence getCity() {
      return City;
    }


    /**
      * Sets the value of the 'City' field.
      * @param value The value of 'City'.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder setCity(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.City = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'City' field has been set.
      * @return True if the 'City' field has been set, false otherwise.
      */
    public boolean hasCity() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'City' field.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder clearCity() {
      City = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'State' field.
      * @return The value.
      */
    public java.lang.CharSequence getState() {
      return State;
    }


    /**
      * Sets the value of the 'State' field.
      * @param value The value of 'State'.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder setState(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.State = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'State' field has been set.
      * @return True if the 'State' field has been set, false otherwise.
      */
    public boolean hasState() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'State' field.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder clearState() {
      State = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'PinCode' field.
      * @return The value.
      */
    public java.lang.CharSequence getPinCode() {
      return PinCode;
    }


    /**
      * Sets the value of the 'PinCode' field.
      * @param value The value of 'PinCode'.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder setPinCode(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.PinCode = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'PinCode' field has been set.
      * @return True if the 'PinCode' field has been set, false otherwise.
      */
    public boolean hasPinCode() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'PinCode' field.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder clearPinCode() {
      PinCode = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ContactNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getContactNumber() {
      return ContactNumber;
    }


    /**
      * Sets the value of the 'ContactNumber' field.
      * @param value The value of 'ContactNumber'.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder setContactNumber(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.ContactNumber = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ContactNumber' field has been set.
      * @return True if the 'ContactNumber' field has been set, false otherwise.
      */
    public boolean hasContactNumber() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ContactNumber' field.
      * @return This builder.
      */
    public types.DeliveryAddress.Builder clearContactNumber() {
      ContactNumber = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public DeliveryAddress build() {
      try {
        DeliveryAddress record = new DeliveryAddress();
        record.AddressLine = fieldSetFlags()[0] ? this.AddressLine : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.City = fieldSetFlags()[1] ? this.City : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.State = fieldSetFlags()[2] ? this.State : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.PinCode = fieldSetFlags()[3] ? this.PinCode : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.ContactNumber = fieldSetFlags()[4] ? this.ContactNumber : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<DeliveryAddress>
    WRITER$ = (org.apache.avro.io.DatumWriter<DeliveryAddress>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<DeliveryAddress>
    READER$ = (org.apache.avro.io.DatumReader<DeliveryAddress>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.AddressLine == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.AddressLine);
    }

    if (this.City == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.City);
    }

    if (this.State == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.State);
    }

    if (this.PinCode == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.PinCode);
    }

    if (this.ContactNumber == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.ContactNumber);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.AddressLine = null;
      } else {
        this.AddressLine = in.readString(this.AddressLine instanceof Utf8 ? (Utf8)this.AddressLine : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.City = null;
      } else {
        this.City = in.readString(this.City instanceof Utf8 ? (Utf8)this.City : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.State = null;
      } else {
        this.State = in.readString(this.State instanceof Utf8 ? (Utf8)this.State : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.PinCode = null;
      } else {
        this.PinCode = in.readString(this.PinCode instanceof Utf8 ? (Utf8)this.PinCode : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.ContactNumber = null;
      } else {
        this.ContactNumber = in.readString(this.ContactNumber instanceof Utf8 ? (Utf8)this.ContactNumber : null);
      }

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.AddressLine = null;
          } else {
            this.AddressLine = in.readString(this.AddressLine instanceof Utf8 ? (Utf8)this.AddressLine : null);
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.City = null;
          } else {
            this.City = in.readString(this.City instanceof Utf8 ? (Utf8)this.City : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.State = null;
          } else {
            this.State = in.readString(this.State instanceof Utf8 ? (Utf8)this.State : null);
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.PinCode = null;
          } else {
            this.PinCode = in.readString(this.PinCode instanceof Utf8 ? (Utf8)this.PinCode : null);
          }
          break;

        case 4:
          if (in.readIndex() != 1) {
            in.readNull();
            this.ContactNumber = null;
          } else {
            this.ContactNumber = in.readString(this.ContactNumber instanceof Utf8 ? (Utf8)this.ContactNumber : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










