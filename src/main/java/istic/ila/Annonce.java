package istic.ila;

import static istic.ila.Persistence.getDatastore;

import java.util.Date;
import java.util.Objects;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.FullEntity.Builder;
import com.google.common.base.MoreObjects;

public class Annonce {

	private Book book;

	public Key key;
	public String authorEmail;
	public String authorId;
	public String titre;
	public int prix;
	public Date date;

	public Annonce() {
		date = new Date();
	}

	public Annonce(String titre, String authorEmail, String authorId) {
		this();
		this.titre = titre;
		this.authorEmail = authorEmail;
		this.authorId = authorId;
	}

	public Annonce(Entity entity) {
		key = entity.hasKey() ? entity.getKey() : null;
		titre = entity.contains("titre") ? entity.getString("titre") : null;
		authorEmail = entity.contains("authorEmail") ? entity.getString("authorEmail") : null;
		authorId = entity.contains("authorId") ? entity.getString("authorId") : null;
	}

	public void save() {
	    if (key == null) {
	      key = getDatastore().allocateId(makeIncompleteKey()); // Give this greeting a unique ID
	    }

	    Builder<Key> builder = FullEntity.newBuilder(key);

	    if (authorEmail != null) {
	      builder.set("authorEmail", authorEmail);
	    }

	    if (authorId != null) {
	      builder.set("authorId", authorId);
	    }

	    builder.set("titre", titre);
	    builder.set("date", Timestamp.of(date));

	    getDatastore().put(builder.build());
	  }

	  private IncompleteKey makeIncompleteKey() {
	    // The book is our ancestor key.
	    return Key.newBuilder(book.getKey(), "Greeting").build();
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
	        && Objects.equals(authorEmail, annonce.authorEmail)
	        && Objects.equals(authorId, annonce.authorId)
	        && Objects.equals(titre, annonce.titre)
	        && Objects.equals(date, annonce.date);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(key, authorEmail, authorId, titre, date);
	  }

	  @Override
	  public String toString() {
	    return MoreObjects.toStringHelper(this)
	        .add("key", key)
	        .add("authorEmail", authorEmail)
	        .add("authorId", authorId)
	        .add("content", titre)
	        .add("date", date)
	        .add("book", book)
	        .toString();
	  }
}
