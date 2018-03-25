package istic.ila;

import static com.google.cloud.datastore.StructuredQuery.OrderBy.desc;
import static com.google.cloud.datastore.StructuredQuery.OrderBy.asc;
import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.hasAncestor;
import static istic.ila.Persistence.getDatastore;
import static istic.ila.Persistence.getKeyFactory;

import java.util.List;
import java.util.Objects;

import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class Catalogue {
	private static final KeyFactory keyFactory = getKeyFactory(Catalogue.class);
	  private final Key key;

	  public final String book;

	  public Catalogue(String book) {
	    this.book = book == null ? "default" : book;
	    key =
	        keyFactory.newKey(
	            this.book); // There is a 1:1 mapping between Guestbook names and Guestbook objects
	  }

	  public Key getKey() {
	    return key;
	  }

	  public List<Annonce> getAnnonces() {
	    // This query requires the index defined in index.yaml to work because of the orderBy on date.
	    EntityQuery query =
	        Query.newEntityQueryBuilder()
	            .setKind("Annonce")
	            .setFilter(hasAncestor(key))
	            .setOrderBy(desc("date"))
	            .setOrderBy(asc("prix"))
	            .setLimit(5)
	            .build();

	    QueryResults<Entity> results = getDatastore().run(query);

	    Builder<Annonce> resultListBuilder = ImmutableList.builder();
	    while (results.hasNext()) {
	      resultListBuilder.add(new Annonce(results.next()));
	    }

	    return resultListBuilder.build();
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Catalogue catalogue = (Catalogue) o;
	    return Objects.equals(book, catalogue.book) && Objects.equals(key, catalogue.key);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(book, key);
	  }

	  @Override
	  public String toString() {
	    return MoreObjects.toStringHelper(this)
	        .add("keyFactory", keyFactory)
	        .add("catalogue", book)
	        .add("key", key)
	        .toString();
	  }
}
