package istic.ila;

import static istic.ila.Persistence.getDatastore;

import java.util.Date;
import java.util.Objects;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.FullEntity.Builder;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.common.base.MoreObjects;

public class Annonce {

	private Catalogue book;

	public Key key;
	public String offre;
	public long prix;
	public Date date;

	public Annonce() {
		date = new Date();
	}

	public Annonce(String offre) {
		this();
		this.offre = offre;
	}
	
	public Annonce(String offre, long prix) {
		this();
		this.offre = offre;
		this.prix = prix;
	}

	public Annonce(Entity entity) {
		key = entity.hasKey() ? entity.getKey() : null;
		offre = entity.contains("offre") ? entity.getString("offre") : null;
		prix = entity.contains("prix") ? entity.getLong("prix") : null;
	}

	public void save() {
	    if (key == null) {
	      key = getDatastore().allocateId(makeIncompleteKey()); // Give this greeting a unique ID
	    }

	    Builder<Key> builder = FullEntity.newBuilder(key);
	    builder.set("offre", offre);
	    builder.set("prix", prix);
	    builder.set("date", Timestamp.of(date));

	    getDatastore().put(builder.build());
	  }

	  private IncompleteKey makeIncompleteKey() {
	    // The book is our ancestor key.
	    return Key.newBuilder(book.getKey(), "Annonce").build();
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Annonce annonce = (Annonce) o;
	    return Objects.equals(key, annonce.key)
	        && Objects.equals(offre, annonce.offre)
	        && Objects.equals(prix, annonce.prix)
	        && Objects.equals(date, annonce.date);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(key, offre, prix, date);
	  }

	  @Override
	  public String toString() {
	    return MoreObjects.toStringHelper(this)
	        .add("key", key)
	        .add("content", offre)
	        .add("date", date)
	        .add("book", book)
	        .toString();
	  }
}
